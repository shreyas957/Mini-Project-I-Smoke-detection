#include <WiFi.h>
#include "secrets.h"
#include "ThingSpeak.h" // always include thingspeak header file after other header files and custom macros

char ssid[] = SECRET_SSID;   // your network SSID (name) 
char pass[] = SECRET_PASS;   // your network password

WiFiClient  client;

unsigned long myChannelNumber = SECRET_CH_ID;
const char * myWriteAPIKey = SECRET_WRITE_APIKEY;

#define sensorPin 34
#define buzzerPin 25

void setup() {
  Serial.begin(115200);  //Initialize serial
  while (!Serial) {
    ; // wait for serial port to connect. Needed for Leonardo native USB port only
  }
  
  WiFi.mode(WIFI_STA);   
  ThingSpeak.begin(client);  // Initialize ThingSpeak
}

void loop() {

  // Connect or reconnect to WiFi
  if(WiFi.status() != WL_CONNECTED){
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(SECRET_SSID);
    while(WiFi.status() != WL_CONNECTED){
      WiFi.begin(ssid, pass); // Connect to WPA/WPA2 network. Change this line if using open or WEP network
      Serial.print(".");
      delay(5000);     
    } 
    Serial.println("\nConnected.");
  }

  int smokeValue = 0;
  smokeValue = analogRead(sensorPin);
  Serial.println("Smoke value : ");
  Serial.println(smokeValue);

  // Write to ThingSpeak. There are up to 8 fields in a channel, allowing you to store up to 8 different
  // pieces of information in a channel.  Here, we write to field 1.
  if(smokeValue > 2000) {
    tone(buzzerPin, 1200, 3000);
    delay(2000);
  }

  if(smokeValue > 300) {
    int x = ThingSpeak.writeField(myChannelNumber, 1, smokeValue, myWriteAPIKey);
    if(x == 200){
      Serial.println("Channel update successful. Code: " + String(x));
    }
    else{
      Serial.println("Problem updating channel. HTTP error code " + String(x));
    }
    delay(20000);
    
  }
  
  delay(1000); 
}
