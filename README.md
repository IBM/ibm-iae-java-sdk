[![Build Status](https://travis-ci.org/IBM/ibm-iae-java-sdk.svg?branch=master)](https://travis-ci.org/IBM/ibm-iae-java-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

# IBM Cloud Analytics Engine SDK Version 0.0.5
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

Service Name | Artifact Id 
--- | --- 
[IBM Analytics Engine APIs](https://cloud.ibm.com/apidocs/ibm-analytics-engine) | ibm-analytics-engine-api

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 0.0.5

#### All the services
To define a dependency on the entire set of services contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.cloud</groupId>
	<artifactId>iaesdk</artifactId>
	<version>0.0.5</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.cloud:iaesdk:0.0.5'
```

#### A single service
To define a dependency on a single service, use a dependency that contains the artifact id for the service, like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>ibm-analytics-engine-api</artifactId>
    <version>0.0.5</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.cloud:ibm-analytics-engine-api:0.0.5'
```
Each service's artifact id is listed in the table of services above.

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

The IBM Cloud MySDK Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
