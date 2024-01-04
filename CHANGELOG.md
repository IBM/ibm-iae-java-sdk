## [1.3.1](https://github.com/IBM/ibm-iae-java-sdk/compare/1.3.0...1.3.1) (2024-01-04)


### Bug Fixes

* update dependencies ([f4b97b6](https://github.com/IBM/ibm-iae-java-sdk/commit/f4b97b63b36e4a0392103302bbf39e215a881254))

# [1.3.0](https://github.com/IBM/ibm-iae-java-sdk/compare/1.2.0...1.3.0) (2024-01-04)


### Features

* add support for application list filters ([66d864b](https://github.com/IBM/ibm-iae-java-sdk/commit/66d864ba21cbb865b7c0ceb2d27e73ece274d56b))

# [1.2.0](https://github.com/IBM/ibm-iae-java-sdk/compare/1.1.1...1.2.0) (2023-05-24)


### Features

* add support for application list pagination ([4c3d2bf](https://github.com/IBM/ibm-iae-java-sdk/commit/4c3d2bfbad13e274351de64a7e08f771ac35a028))

## [1.1.1](https://github.com/IBM/ibm-iae-java-sdk/compare/1.1.0...1.1.1) (2023-03-23)


### Bug Fixes

* fix build configuration ([c479dab](https://github.com/IBM/ibm-iae-java-sdk/commit/c479dab821a797e7b87fdef7692ae39ed4d10e67))

# [1.1.0](https://github.com/IBM/ibm-iae-java-sdk/compare/1.0.0...1.1.0) (2023-03-23)


### Bug Fixes

* fix configuration error ([296109d](https://github.com/IBM/ibm-iae-java-sdk/commit/296109de087e598753e1dfc0d6d61543ea9f87d4))


### Features

* add new sdk method to update instance home credentials ([4bb7ecc](https://github.com/IBM/ibm-iae-java-sdk/commit/4bb7eccaf9f533fce03039632ec905967df050dd))
* add new sdk method to update instance home credentials ([ab9d73c](https://github.com/IBM/ibm-iae-java-sdk/commit/ab9d73c81516d145519168c8edd6e2e2782382e7))

# [1.0.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.6.0...1.0.0) (2023-01-05)


### Features

* add spark history server api ([9201b7d](https://github.com/IBM/ibm-iae-java-sdk/commit/9201b7da4da30c615d28e1df69e321adb1a533fc))


### BREAKING CHANGES

* Type of timestamp fields in Application response models has been changed to `Date`.

The type of timestamp fields like startTime, endTime in `ApplicationGetStateResponse` and `Application` models has been changed from `String` to `Date`.

Signed-off-by: Subin Shekhar <subinpc@gmail.com>

# [0.6.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.5.3...0.6.0) (2022-11-24)


### Features

* add sdk methods and update models for v3 ([7f7677a](https://github.com/IBM/ibm-iae-java-sdk/commit/7f7677a2ca730133893787280828e2cddff14d25))

## [0.5.3](https://github.com/IBM/ibm-iae-java-sdk/compare/0.5.2...0.5.3) (2022-09-24)


### Bug Fixes

* allow javadoc generation for examples ([b651d20](https://github.com/IBM/ibm-iae-java-sdk/commit/b651d2027df4aaf39969275d69cd88ce12ca67b0))

## [0.5.2](https://github.com/IBM/ibm-iae-java-sdk/compare/0.5.1...0.5.2) (2022-09-23)


### Bug Fixes

* update signing step ([8763afc](https://github.com/IBM/ibm-iae-java-sdk/commit/8763afcdd6d03634320e0a559a4266fd6949d792))

## [0.5.1](https://github.com/IBM/ibm-iae-java-sdk/compare/0.5.0...0.5.1) (2022-09-23)


### Bug Fixes

* examples ([b659a65](https://github.com/IBM/ibm-iae-java-sdk/commit/b659a656be3250497cabe27619b18a9a9cfb2b8a))
* remove trailing spaces ([649e213](https://github.com/IBM/ibm-iae-java-sdk/commit/649e21366bac33676f4273ca21434447d348c5ff))

# [0.5.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.4.2...0.5.0) (2022-09-08)


### Features

* add sdk methods for v3 api and update dependencies ([518998a](https://github.com/IBM/ibm-iae-java-sdk/commit/518998a3d1d5dba63a5eda0e240fef2a3173ae07))

## [0.4.2](https://github.com/IBM/ibm-iae-java-sdk/compare/0.4.1...0.4.2) (2021-09-08)


### Bug Fixes

* **analytics engine:** fixed request payload for Java Examples ([#7](https://github.com/IBM/ibm-iae-java-sdk/issues/7)) ([22b8c65](https://github.com/IBM/ibm-iae-java-sdk/commit/22b8c65f6384428d6e0eecbc339cdf0567b77879))

## [0.4.1](https://github.com/IBM/ibm-iae-java-sdk/compare/0.4.0...0.4.1) (2021-09-07)


### Bug Fixes

* **analytics engine:** Modified Java SDK V3 changes ([#6](https://github.com/IBM/ibm-iae-java-sdk/issues/6)) ([df56d1a](https://github.com/IBM/ibm-iae-java-sdk/commit/df56d1a97867e56d6678e65af32cf38b653392cf))

# [0.4.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.3.0...0.4.0) (2021-08-11)


### Features

* analytics engine v3 feature changes ([2f9c06f](https://github.com/IBM/ibm-iae-java-sdk/commit/2f9c06f93b5a739e302e23704fb12e6826bf264d))

# [0.3.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.2.0...0.3.0) (2021-08-11)


### Features

* analytics engine v3 feature changes ([#4](https://github.com/IBM/ibm-iae-java-sdk/issues/4)) ([55a11ac](https://github.com/IBM/ibm-iae-java-sdk/commit/55a11ac9e65a766286fd92f5522bf55ebf2d25c6))

# [0.2.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.1.0...0.2.0) (2021-08-10)


### Features

* analytics engine v3 feature changes ([9b157d7](https://github.com/IBM/ibm-iae-java-sdk/commit/9b157d7f5458b51e48bc3281f56899a0c2451d62))

# [0.1.0](https://github.com/IBM/ibm-iae-java-sdk/compare/0.0.5...0.1.0) (2020-05-28)


### Features

* **whitelist api:** Adding whitelisting apis ([4016cbf](https://github.com/IBM/ibm-iae-java-sdk/commit/4016cbf0c9e039eade628bf2835fa9729330c167))
* **whitelist api:** Adding whitelisting apis and updating build to not sign ([4c79416](https://github.com/IBM/ibm-iae-java-sdk/commit/4c79416df48754fb66c84f70341f50f78e002a39))

## [0.0.5](https://github.com/IBM/ibm-iae-java-sdk/compare/0.0.4...0.0.5) (2020-05-13)


### Bug Fixes

* **sign:** updating build to sign files ([8d11c8c](https://github.com/IBM/ibm-iae-java-sdk/commit/8d11c8c2ca7ed5a2bb5c0e2fdcd4d24686bcd48a))

## [0.0.4](https://github.com/IBM/ibm-iae-java-sdk/compare/0.0.3...0.0.4) (2020-05-11)


### Bug Fixes

* **build:** update pom to build sources ([699bb04](https://github.com/IBM/ibm-iae-java-sdk/commit/699bb04b8e7a7239fc8d8d3e3b521717e9756600))

## [0.0.3](https://github.com/IBM/ibm-iae-java-sdk/compare/0.0.2...0.0.3) (2020-05-08)


### Bug Fixes

* **build:** fix publish gh-pages script ([7924192](https://github.com/IBM/ibm-iae-java-sdk/commit/7924192d6f73519b76e3ebbd7271616f92e92e63))

## [0.0.2](https://github.com/IBM/ibm-iae-java-sdk/compare/0.0.1...0.0.2) (2020-05-08)


### Bug Fixes

* **build:** publish SDK ([d24f264](https://github.com/IBM/ibm-iae-java-sdk/commit/d24f2642b7142c628312371d38149bd58294013c))
