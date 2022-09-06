/*
 * (C) Copyright IBM Corp. 2022.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application details.
 */
public class ApplicationDetails extends GenericModel {

  protected String application;
  protected String jars;
  protected String packages;
  protected String repositories;
  protected String files;
  protected String archives;
  protected String name;
  @SerializedName("class")
  protected String xClass;
  protected List<String> arguments;
  protected Map<String, Object> conf;
  protected Map<String, Object> env;

  /**
   * Gets the application.
   *
   * Path of the application to run.
   *
   * @return the application
   */
  public String getApplication() {
    return application;
  }

  /**
   * Gets the jars.
   *
   * Path of the jar files containing the application.
   *
   * @return the jars
   */
  public String getJars() {
    return jars;
  }

  /**
   * Gets the packages.
   *
   * Package names.
   *
   * @return the packages
   */
  public String getPackages() {
    return packages;
  }

  /**
   * Gets the repositories.
   *
   * Repositories names.
   *
   * @return the repositories
   */
  public String getRepositories() {
    return repositories;
  }

  /**
   * Gets the files.
   *
   * File names.
   *
   * @return the files
   */
  public String getFiles() {
    return files;
  }

  /**
   * Gets the archives.
   *
   * Archive Names.
   *
   * @return the archives
   */
  public String getArchives() {
    return archives;
  }

  /**
   * Gets the name.
   *
   * Name of the application.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the xClass.
   *
   * Entry point for a Spark application bundled as a '.jar' file. This is applicable only for Java or Scala
   * applications.
   *
   * @return the xClass
   */
  public String getXClass() {
    return xClass;
  }

  /**
   * Gets the arguments.
   *
   * An array of arguments to be passed to the application.
   *
   * @return the arguments
   */
  public List<String> getArguments() {
    return arguments;
  }

  /**
   * Gets the conf.
   *
   * Application configurations to override the value specified at instance level. See [Spark environment variables](
   * https://spark.apache.org/docs/latest/configuration.html#available-properties) for a list of the supported
   * variables.
   *
   * @return the conf
   */
  public Map<String, Object> getConf() {
    return conf;
  }

  /**
   * Gets the env.
   *
   * Application environment configurations to use. See [Spark environment
   * variables](https://spark.apache.org/docs/latest/configuration.html#environment-variables) for a list of the
   * supported variables.
   *
   * @return the env
   */
  public Map<String, Object> getEnv() {
    return env;
  }
}

