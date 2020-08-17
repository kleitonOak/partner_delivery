# Ze Delivery Challenge By [José Kleiton](https://github.com/kleitonOak)

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

Important to say that Geo Information provided by [ZE COMPANY](https://github.com/ZXVentures/ze-code-challenges/blob/master/files/pdvs.json) was not valid to input information due the [Right Hand Rule violation](https://mapster.me/right-hand-rule-geojson-fixer)  
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