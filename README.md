[![Build Status](https://api.travis-ci.com/IBM/ibm-iae-java-sdk.svg?branch=master)](https://app.travis-ci.com/github/IBM/ibm-iae-java-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

# IBM Cloud Analytics Engine SDK Version 1.1.1
Java client library to interact with various [IBM Analytics Engine APIs](https://cloud.ibm.com/apidocs/ibm-analytics-engine).

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc -i README.md
  -->

<!-- toc -->

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
    + [All the services](#all-the-services)
    + [A single service](#a-single-service)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Issues](#issues)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

## Overview

The IBM Cloud Analytics Engine Services Java SDK allows developers to programmatically interact with the following IBM Cloud services:

Service Name | Artifact Coordinates 
--- | --- 
[IBM Analytics Engine APIs v2](https://cloud.ibm.com/apidocs/ibm-analytics-engine/ibm-analytics-engine-v2?code=java) | com.ibm.cloud:ibm-analytics-engine-api:1.1.1
[IBM Analytics Engine APIs v3](https://cloud.ibm.com/apidocs/ibm-analytics-engine/ibm-analytics-engine-v3?code=java) | com.ibm.cloud:ibm-analytics-engine-api:1.1.1

The module name for both the versions are same : `ibm-analytics-engine-api`
The two versions are differntiated by the version number in the Java package structure. Example : `com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2` vs `com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3`

**NOTE**

IBM Analytics Engine v2 is for the classic plans : Lite, Standard Hourly and Standard monthly.
The classic plans are now deprecated.

IBM Analytics Engine v3 is for the Standard Serverless for Apache Spark plan.


## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 1.1.1

Each service's artifact coordinates are listed in the table above.

The project artifacts are published on the public [Maven Central](https://repo1.maven.org/maven2/)
artifact repository.  This is the default public repository used by maven when searching for dependencies.
To use this repository within a gradle build, please see
[this link](https://docs.gradle.org/current/userguide/declaring_repositories.html).

To use a particular service in your application, define a dependency that contains the
artifact coordinates (group id, artifact id and version) for the service.
Here are examples for maven and gradle:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>ibm-analytics-engine-api</artifactId>
    <version>1.1.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.cloud:ibm-analytics-engine-api:1.1.1'
```


## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)


## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/ibm-iae-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud Analytics Engine Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
