import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class Kafka {

    public final static String applicationID = "ggggg";
    public final static String bootstrapServers = "localhost:9092,localhost:9093";
    public final static String topicName = "hello-producer";

    private static final Logger logger = LogManager.getLogger(Kafka.class);

    public static void notifyServer(String name) {

        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, applicationID);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);

        try {
            producer.send(new ProducerRecord<>(topicName, 1, "Act recived " + name));
        } catch (Exception e) {

        }
        //producer.close();
    }
}

