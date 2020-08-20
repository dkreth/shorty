# shorty

## Clone the project
`git pull git@github.com:dkreth/shorty.git && cd shorty`

## Run the project
`./gradlew bootRun`

## Use the project
#### Test endpoint 
GET localhost:8080/test

#### Create a new shorty
POST localhost:8080/generate with JSON body
```
{
    "shortId": "dk",
    "longUrl": "dylankreth.com"
}
```

#### Use the shorty
Point a web browser to localhost:8080/dk