# Partnet Challenge By [José Kleiton](https://github.com/kleitonOak)

API that keeps Partner operations.
- Save in a database a partner defined by all the fields represented by the JSON and rules below:
```
{
  "id": 1, 
  "tradingName": "Adega da Cerveja - Pinheiros",
  "ownerName": "Zé da Silva",
  "document": "1432132123891/0001",
  "coverageArea": { 
    "type": "MultiPolygon", 
    "coordinates": [
      [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
      [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
    ]
  },
  "address": { 
    "type": "Point",
    "coordinates": [-46.57421, -21.785741]
  }
}
```

Check invalid input information caused by [Right Hand Rule violation](https://mapster.me/right-hand-rule-geojson-fixer)  
- Find by ID: Return a specific partner by its id with all the fields presented above.
- Search partner: Given a specific location (coordinates long and lat), search the nearest partner which the coverage area includes the location.

## Recommended
- Intellij IDE

## Pre requirements
1. Docker and Docker Compose.
2. Java versions 11 minimum.

## Build
On console:
`./gradlew clean build`

## Run the project

On console:
`./gradlew bootRun` this command was configured to run with Docker Run MongoDB

## DataBase

MongoDB using Geospatial Queries. Using databasename `ze_delivery` and collection `partner`, with three index: 
1. ``` db.getCollection('partner').createIndex({"address":"2dsphere"})```
2. ``` db.getCollection('partner').createIndex({"coverageArea":"2dsphere"})```
3. ``` db.getCollection('partner').createIndex({"document":"text"})```

## Documentation

- [ Endpoints / Swagger](http://localhost:8080/swagger)

## Researchs
- [ Validate GeoJson format](https://geojsonlint.com)
- [ Problem with old version of GeoJson](https://mapster.me/right-hand-rule-geojson-fixer)
- [ Geospatial Queries MongoDB](https://docs.mongodb.com/manual/tutorial/geospatial-tutorial)

## Application Structure

##### Core: Entities
* Represent your domain object
* Apply only logic that is applicable in general to the whole entity (e.g. validating the format of an hostname)
* Plain java objects: no frameworks, no annotations

##### Core: Use Cases
* Represent your business actions, it’s what you can do with the application. Expect one use case for each business action
* Pure business logic, plain java (expect maybe some utils libraries like StringUtils)
* Define interfaces for the data that they need in order to apply some logic. One or more dataproviders will implement the interface, but the use case doesn’t know where the data is coming from
* The use case doesn't know who triggered it and how the results are going to be presented (e.g. could be on a web page, or returned as json, or simply logged, etc.)
* Throws business exceptions

##### Dataproviders
* Retrieve and store data from and to a number of sources (database, network devices, file system, 3rd parties, etc.)
* Implement the interfaces defined by the use case
* Use whatever framework is most appropriate (they are going to be isolated here anyway)
* Note: if using an ORM for database access, here you'd have another set of objects in order to represent the mapping to the tables (don't use the core entities as they might be very different)

##### Entrypoints
* Are ways to interact with the application, and typically involve a delivery mechanism (e.g. REST APIs, scheduled jobs, GUI, other systems)
* Trigger a use case and convert the result to the appropriate format for the delivery mechanism
* A GUI would use MVC (or MVP) in here; the controller would trigger a use case

##### Configuration
* Wires everything together
* Frameworks (e.g. for dependency injection) are isolated here
* Has the "dirty details" like Main class, web server configuration, datasource configuration, etc.

[Source](https://github.com/mattia-battiston)
