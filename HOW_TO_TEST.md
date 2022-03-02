# How to run tests

## Pre-requisites
1. Make sure `mvn` is installed on your computer.
2. Ensure that your JAVA_HOME is set correctly
    `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home` 
3. Download [SDK generation code](https://github.ibm.com/CloudEngineering/openapi-sdkgen/releases) 
4. Clone [`Java SDK`] https://github.com/IBM/ibm-iae-java-sdk/
5. Generate the sdk code with: 
    `openapi-sdkgen/openapi-sdkgen.sh generate -g ibm-java -i ibmanalyticsengine-v3.json -o /Users/git/ibm-iae-java-sdk/modules --genITs --genExamples`

## Integration Tests

1. To merge with remote version pick the code marked between and update `IbmAnalyticsEngineApiIT.java`
    `// !!! Start of custom content to be copied !!!`
    `// !!! End of custom content to be copied !!!`
2. Create a `ibm_analytics_engine_api_v3.env` file in the `ibm-iae-java-sdk` directory using `ibmanalyticsengine-service.env.hide` as an example.
3. Update `ibm_analytics_engine_api_v3.env` file with your own **APIKEY** and other details.
4. export instance guid as `IBM_ANALYTICS_ENGINE_INSTANCE_GUID` environment variable.
5. export nstance guid to cretae instance home as `IBM_ANALYTICS_ENGINE_INSTANCE_GUID_INSTANCE_HOME` environment variable.
6. export HMAC access key as `IBM_ANALYTICS_ENGINE_HMAC_ACCESS_KEY` environment variable.
7. export HMAC secret key as `IBM_ANALYTICS_ENGINE_HMAC_SECRET_KEY` environment variable.
8. Go to Project's root directory `ibm-iae-java-sdk/` directory.
    Run `mvn test -DfailIfNoTests=false -Dtest=IbmAnalyticsEngineApiIT`

## Unit Tests

1. Go to Project's root directory `ibm-iae-java-sdk/` directory.
2. Run `mvn test`.