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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response of Instance home API.
 */
public class InstanceHomeResponse extends GenericModel {

  @SerializedName("instance_id")
  protected String instanceId;
  protected String provider;
  protected String type;
  protected String region;
  protected String endpoint;
  @SerializedName("hmac_access_key")
  protected String hmacAccessKey;
  @SerializedName("hmac_secret_key")
  protected String hmacSecretKey;

  protected InstanceHomeResponse() { }

  /**
   * Gets the instanceId.
   *
   * UUID of the instance home storage instance.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the provider.
   *
   * Currently only ibm-cos (IBM Cloud Object Storage) is supported.
   *
   * @return the provider
   */
  public String getProvider() {
    return provider;
  }

  /**
   * Gets the type.
   *
   * Type of the instance home storage. Currently, only objectstore (Cloud Object Storage) is supported.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the region.
   *
   * Region of the Cloud Object Storage instance.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Gets the endpoint.
   *
   * Endpoint to access the Cloud Object Storage instance.
   *
   * @return the endpoint
   */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Gets the hmacAccessKey.
   *
   * Cloud Object Storage access key.
   *
   * @return the hmacAccessKey
   */
  public String getHmacAccessKey() {
    return hmacAccessKey;
  }

  /**
   * Gets the hmacSecretKey.
   *
   * Cloud Object Storage secret key.
   *
   * @return the hmacSecretKey
   */
  public String getHmacSecretKey() {
    return hmacSecretKey;
  }
}

