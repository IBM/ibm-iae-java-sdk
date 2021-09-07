/*
 * (C) Copyright IBM Corp. 2021.
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
    private String xClass;
    private List<String> arguments;
    private Map<String, Object> conf;
    private Map<String, Object> env;

    private Builder(ApplicationRequestApplicationDetails applicationRequestApplicationDetails) {
      this.application = applicationRequestApplicationDetails.application;
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

  protected ApplicationRequestApplicationDetails(Builder builder) {
    application = builder.application;
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

