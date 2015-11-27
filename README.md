## Allegro API service
This project is using jaxb library to extract classes from SOAP wsdl file

wsdl is supplied by Allegro. see more at:

http://allegro.pl/webapi/documentation.php

The SOAP service is being served by classes using spring-ws.

The goal is to produce easily consumable JSON files.

### Allegro Api key
To use the Allegro Api it is required to register account and generate Api key.

After this step create file : src\main\resources\application.properties containing line:

```
allegro.api.key=secretKey
```

Or put it in your system env table (strongly sugested!), ie:

```
set ALLEGRO_API_KEY=SECRET_KEY
```

### REST Service
After tomcat is started you get following REST functionality

GET:

- /allegro/offers
- /allegro/preferredoffers

### CloudFoundry support
If you wish you can deploy to cf.

Create gradle.properties file in root of project with contents:

```
cfUsername=
cfPassword=
cfApp=
cfOrganization=
cfSpace=
cfUri=
```

Execute deploy with: gradle cfPush