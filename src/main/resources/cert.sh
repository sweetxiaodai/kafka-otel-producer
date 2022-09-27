keytool -export -alias caroot -keystore kafka.client.truststore.jks -file caroot.cer
keytool -list -v -keystore kafka.client.truststore.jks
KafkaOnsClient

keytool -importcert -alias caroot -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit -file aliyun.cer


keytool -import -alias aliyun -file aliyun.cer -keystore kafka.client.truststore.jks -storepass KafkaOnsClient