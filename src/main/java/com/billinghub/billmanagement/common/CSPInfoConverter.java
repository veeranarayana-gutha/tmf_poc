package com.billinghub.billmanagement.common;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.billinghub.billmanagement.model.CSPInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CSPInfoConverter implements MessageConverter {
	private final ObjectMapper objectMapper;

	@Autowired
	 public CSPInfoConverter(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	}
	 
	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
		try {
			byte[] bytes = objectMapper.writeValueAsBytes(object);
			messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
			return new Message(bytes, messageProperties);
		} catch (Exception e) {
			throw new MessageConversionException("Failed to convert message to JSON", e);
		}
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		CSPInfo cspInfo = null;
		try {
			JsonNode rootNode = objectMapper.readTree(message.getBody());
			cspInfo = new CSPInfo();
			Optional.ofNullable(rootNode.get("id")).map(JsonNode::asLong).ifPresent(cspInfo::setCspId);
			Optional.ofNullable(rootNode.get("cspName")).map(JsonNode::asText).ifPresent(cspInfo::setCspName);
			cspInfo.setJson(new String(message.getBody(), StandardCharsets.UTF_8));
		} catch (Exception e) {
			throw new MessageConversionException("Failed to convert message from JSON", e);
		}
		return cspInfo;
	}

}
