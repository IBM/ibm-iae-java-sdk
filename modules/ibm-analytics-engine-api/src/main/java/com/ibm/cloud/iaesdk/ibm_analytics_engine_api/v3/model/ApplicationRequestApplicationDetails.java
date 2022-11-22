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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application details.
 */
public class ApplicationRequestApplicationDetails extends GenericModel {

  protected String application;
  protected Runtime runtime;
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
   * Builder.
   */
  public static class Builder {
    private String application;
    private Runtime runtime;
    private String jars;
    private String packages;
    private String repositories;
    private String files;
    private String archives;
    private String name;
    private String xClass;
    private List<String> arguments;
    private Map<String, Object> conf;
    private Map<String, Object> env;

    private Builder(ApplicationRequestApplicationDetails applicationRequestApplicationDetails) {
      this.application = applicationRequestApplicationDetails.application;
      this.runtime = applicationRequestApplicationDetails.runtime;
      this.jars = applicationRequestApplicationDetails.jars;
      this.packages = applicationRequestApplicationDetails.packages;
      this.repositories = applicationRequestApplicationDetails.repositories;
      this.files = applicationRequestApplicationDetails.files;
      this.archives = applicationRequestApplicationDetails.archives;
      this.name = applicationRequestApplicationDetails.name;
      this.xClass = applicationRequestApplicationDetails.xClass;
      this.arguments = applicationRequestApplicationDetails.arguments;
      this.conf = applicationRequestApplicationDetails.conf;
      this.env = applicationRequestApplicationDetails.env;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ApplicationRequestApplicationDetails.
     *
     * @return the new ApplicationRequestApplicationDetails instance
     */
    public ApplicationRequestApplicationDetails build() {
      return new ApplicationRequestApplicationDetails(this);
    }

    /**
     * Adds an arguments to arguments.
     *
     * @param arguments the new arguments
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder addArguments(String arguments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(arguments,
        "arguments cannot be null");
      if (this.arguments == null) {
        this.arguments = new ArrayList<String>();
      }
      this.arguments.add(arguments);
      return this;
    }

    /**
     * Set the application.
     *
     * @param application the application
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder application(String application) {
      this.application = application;
      return this;
    }

    /**
     * Set the runtime.
     *
     * @param runtime the runtime
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder runtime(Runtime runtime) {
      this.runtime = runtime;
      return this;
    }

    /**
     * Set the jars.
     *
     * @param jars the jars
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder jars(String jars) {
      this.jars = jars;
      return this;
    }

    /**
     * Set the packages.
     *
     * @param packages the packages
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder packages(String packages) {
      this.packages = packages;
      return this;
    }

    /**
     * Set the repositories.
     *
     * @param repositories the repositories
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder repositories(String repositories) {
      this.repositories = repositories;
      return this;
    }

    /**
     * Set the files.
     *
     * @param files the files
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder files(String files) {
      this.files = files;
      return this;
    }

    /**
     * Set the archives.
     *
     * @param archives the archives
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder archives(String archives) {
      this.archives = archives;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the xClass.
     *
     * @param xClass the xClass
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder xClass(String xClass) {
      this.xClass = xClass;
      return this;
    }

    /**
     * Set the arguments.
     * Existing arguments will be replaced.
     *
     * @param arguments the arguments
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder arguments(List<String> arguments) {
      this.arguments = arguments;
      return this;
    }

    /**
     * Set the conf.
     *
     * @param conf the conf
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder conf(Map<String, Object> conf) {
      this.conf = conf;
      return this;
    }

    /**
     * Set the env.
     *
     * @param env the env
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder env(Map<String, Object> env) {
      this.env = env;
      return this;
    }
  }

  protected ApplicationRequestApplicationDetails() { }

  protected ApplicationRequestApplicationDetails(Builder builder) {
    application = builder.application;
    runtime = builder.runtime;
    jars = builder.jars;
    packages = builder.packages;
    repositories = builder.repositories;
    files = builder.files;
    archives = builder.archives;
    name = builder.name;
    xClass = builder.xClass;
    arguments = builder.arguments;
    conf = builder.conf;
    env = builder.env;
  }

  /**
   * New builder.
   *
   * @return a ApplicationRequestApplicationDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the application.
   *
   * Path of the application to run.
   *
   * @return the application
   */
  public String application() {
    return application;
  }

  /**
   * Gets the runtime.
   *
   * Runtime enviroment for applications and other workloads.
   *
   * @return the runtime
   */
  public Runtime runtime() {
    return runtime;
  }

  /**
   * Gets the jars.
   *
   * Path of the jar files containing the application.
   *
   * @return the jars
   */
  public String jars() {
    return jars;
  }

  /**
   * Gets the packages.
   *
   * Package names.
   *
   * @return the packages
   */
  public String packages() {
    return packages;
  }

  /**
   * Gets the repositories.
   *
   * Repositories names.
   *
   * @return the repositories
   */
  public String repositories() {
    return repositories;
  }

  /**
   * Gets the files.
   *
   * File names.
   *
   * @return the files
   */
  public String files() {
    return files;
  }

  /**
   * Gets the archives.
   *
   * Archive Names.
   *
   * @return the archives
   */
  public String archives() {
    return archives;
  }

  /**
   * Gets the name.
   *
   * Name of the application.
   *
   * @return the name
   */
  public String name() {
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
  public String xClass() {
    return xClass;
  }

  /**
   * Gets the arguments.
   *
   * An array of arguments to be passed to the application.
   *
   * @return the arguments
   */
  public List<String> arguments() {
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
  public Map<String, Object> conf() {
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
  public Map<String, Object> env() {
    return env;
  }
}

