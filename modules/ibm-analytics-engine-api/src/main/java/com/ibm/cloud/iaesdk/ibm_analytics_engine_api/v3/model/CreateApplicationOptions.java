/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createApplication options.
 */
public class CreateApplicationOptions extends GenericModel {

  protected String instanceId;
  protected ApplicationRequestApplicationDetails applicationDetails;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private ApplicationRequestApplicationDetails applicationDetails;

    /**
     * Instantiates a new Builder from an existing CreateApplicationOptions instance.
     *
     * @param createApplicationOptions the instance to initialize the Builder with
     */
    private Builder(CreateApplicationOptions createApplicationOptions) {
      this.instanceId = createApplicationOptions.instanceId;
      this.applicationDetails = createApplicationOptions.applicationDetails;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a CreateApplicationOptions.
     *
     * @return the new CreateApplicationOptions instance
     */
    public CreateApplicationOptions build() {
      return new CreateApplicationOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateApplicationOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the applicationDetails.
     *
     * @param applicationDetails the applicationDetails
     * @return the CreateApplicationOptions builder
     */
    public Builder applicationDetails(ApplicationRequestApplicationDetails applicationDetails) {
      this.applicationDetails = applicationDetails;
      return this;
    }
  }

  protected CreateApplicationOptions() { }

  protected CreateApplicationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    applicationDetails = builder.applicationDetails;
  }

  /**
   * New builder.
   *
   * @return a CreateApplicationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The identifier of the Analytics Engine instance associated with the Spark application(s).
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the applicationDetails.
   *
   * Application details.
   *
   * @return the applicationDetails
   */
  public ApplicationRequestApplicationDetails applicationDetails() {
    return applicationDetails;
  }
}

