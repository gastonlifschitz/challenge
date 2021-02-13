# What you need

1. Java
2. Maven

# How to execute

1. `mvn install`
2. `java -jar ./target/javaspringapp-1.0-SNAPSHOT.jar`


## Productive end point

http://java-spring-app-eywxh-2021-02-12.us-south.cf.appdomain.cloud/v1/topsecret

## Test

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "satellites": [
        {
            "name": "kenobi",
            "distance": 100.0,
            "message": [
                "este",
                "",
                "",
                "mensaje",
                ""
            ]
        },
        {
            "name": "skywalker",
            "distance": 115.5,
            "message": [
                "",
                "es",
                "",
                "",
                "secreto"
            ]
        },
        {
            "name": "sato",
            "distance": 142.7,
            "message": [
                "este",
                "",
                "un",
                "",
                ""
            ]
        }
    ]
}' http://java-spring-app-eywxh-2021-02-12.us-south.cf.appdomain.cloud/v1/topsecret


#### Native Application Development

* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](http://www.ibm.com/developerworks/java/jdk/),
    or [Download a Liberty server package](https://developer.ibm.com/assets/wasdev/#filter/assetTypeFilters=PRODUCT)
    that contains the IBM JDK (Windows, Linux)

To build and run an application:

1. `mvn install`
2. `java -jar ./target/javaspringapp-1.0-SNAPSHOT.jar`

To run an application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

You can verify the state of your locally running application using the Selenium UI test script included in the `scripts` directory.

