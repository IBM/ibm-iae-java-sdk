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
  @SerializedName("application_arguments")
  protected List<String> applicationArguments;
  protected Map<String, Object> conf;
  protected Map<String, Object> env;

  /**
   * Builder.
   */
  public static class Builder {
    private String application;
    private String xClass;
    private List<String> applicationArguments;
    private Map<String, Object> conf;
    private Map<String, Object> env;

    private Builder(ApplicationRequestApplicationDetails applicationRequestApplicationDetails) {
      this.application = applicationRequestApplicationDetails.application;
      this.xClass = applicationRequestApplicationDetails.xClass;
      this.applicationArguments = applicationRequestApplicationDetails.applicationArguments;
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
     * Adds an applicationArguments to applicationArguments.
     *
     * @param applicationArguments the new applicationArguments
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder addApplicationArguments(String applicationArguments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(applicationArguments,
        "applicationArguments cannot be null");
      if (this.applicationArguments == null) {
        this.applicationArguments = new ArrayList<String>();
      }
      this.applicationArguments.add(applicationArguments);
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
     * Set the applicationArguments.
     * Existing applicationArguments will be replaced.
     *
     * @param applicationArguments the applicationArguments
     * @return the ApplicationRequestApplicationDetails builder
     */
    public Builder applicationArguments(List<String> applicationArguments) {
      this.applicationArguments = applicationArguments;
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
    applicationArguments = builder.applicationArguments;
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
   * Application name.
   *
   * @return the application
   */
  public String application() {
    return application;
  }

  /**
   * Gets the xClass.
   *
   * The entry point for your application.
   *
   * @return the xClass
   */
  public String xClass() {
    return xClass;
  }

  /**
   * Gets the applicationArguments.
   *
   * Application arguments.
   *
   * @return the applicationArguments
   */
  public List<String> applicationArguments() {
    return applicationArguments;
  }

  /**
   * Gets the conf.
   *
   * Application configurations to override. See [Spark environment variables](
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
   * Application environment configurations to override. See [Spark environment
   * variables](https://spark.apache.org/docs/latest/configuration.html#environment-variables) for a list of the
   * supported variables.
   *
   * @return the env
   */
  public Map<String, Object> env() {
    return env;
  }
}

