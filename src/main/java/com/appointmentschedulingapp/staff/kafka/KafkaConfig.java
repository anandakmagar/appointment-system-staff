package com.appointmentschedulingapp.staff.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "measured-yeti-6624-us1-kafka.upstash.io:9092");
        configs.put("security.protocol", "SASL_SSL");
        configs.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
        configs.put(SaslConfigs.SASL_JAAS_CONFIG,
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"bWVhc3VyZWQteWV0aS02NjI0JG13TuzeYPCNpNbFHZ-fEuClCyG3XnAXVORHS1k\" password=\"N2IyMzg1YTEtZjAwYy00YjE3LWE5ZGEtMjRlNzYxMzdiY2Iw\";");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic staffRegistrationTopic() {
        return new NewTopic("staff-registration", 1, (short) 1);
    }

    @Bean
    public NewTopic staffUpdateTopic() {
        return new NewTopic("staff-update", 1, (short) 1);
    }

    @Bean
    public NewTopic staffDeletionTopic() {
        return new NewTopic("staff-deletion", 1, (short) 1);
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "measured-yeti-6624-us1-kafka.upstash.io:9092");
        configProps.put("security.protocol", "SASL_SSL");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
        configProps.put(SaslConfigs.SASL_JAAS_CONFIG,
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"bWVhc3VyZWQteWV0aS02NjI0JG13TuzeYPCNpNbFHZ-fEuClCyG3XnAXVORHS1k\" password=\"N2IyMzg1YTEtZjAwYy00YjE3LWE5ZGEtMjRlNzYxMzdiY2Iw\";");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
