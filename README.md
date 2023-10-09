# FrequencyCounterAPI

This is a REST API for counting amount of entries of same character in given String. The project uses Spring.

## REST API Endpoints

The following table lists the REST API endpoints that are available in this API:

| **HTTP Method** | **Endpoint**                                     | **Description**                                                              |
|-----------------|--------------------------------------------------|------------------------------------------------------------------------------|
| GET             | /frequency-api                                   | Get frequency map for input string (must have json content with that string) |                                                                                                                                    |

For information about possible responses please consider reading JavaDoc for class FrequencyController
