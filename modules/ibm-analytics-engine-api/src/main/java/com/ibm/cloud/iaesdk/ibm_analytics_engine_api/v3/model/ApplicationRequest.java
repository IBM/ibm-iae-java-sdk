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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application request details.
 */
public class ApplicationRequest extends GenericModel {

  @SerializedName("application_details")
  protected ApplicationRequestApplicationDetails applicationDetails;

  /**
   * Builder.
   */
  public static class Builder {
    private ApplicationRequestApplicationDetails applicationDetails;

    private Builder(ApplicationRequest applicationRequest) {
      this.applicationDetails = applicationRequest.applicationDetails;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ApplicationRequest.
     *
     * @return the new ApplicationRequest instance
     */
    public ApplicationRequest build() {
      return new ApplicationRequest(this);
    }

    /**
     * Set the applicationDetails.
     *
     * @param applicationDetails the applicationDetails
     * @return the ApplicationRequest builder
     */
    public Builder applicationDetails(ApplicationRequestApplicationDetails applicationDetails) {
      this.applicationDetails = applicationDetails;
      return this;
    }
  }

  protected ApplicationRequest(Builder builder) {
    applicationDetails = builder.applicationDetails;
  }

  /**
   * New builder.
   *
   * @return a ApplicationRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

