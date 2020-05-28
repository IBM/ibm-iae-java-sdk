/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updatePrivateEndpointWhitelist options.
 */
public class UpdatePrivateEndpointWhitelistOptions extends GenericModel {

  /**
   * Update Whitelist IP ranges. Add (or) Delete.
   */
  public interface Action {
    /** add. */
    String ADD = "add";
    /** delete. */
    String DELETE = "delete";
  }

  protected String instanceGuid;
  protected List<String> ipRanges;
  protected String action;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private List<String> ipRanges;
    private String action;

    private Builder(UpdatePrivateEndpointWhitelistOptions updatePrivateEndpointWhitelistOptions) {
      this.instanceGuid = updatePrivateEndpointWhitelistOptions.instanceGuid;
      this.ipRanges = updatePrivateEndpointWhitelistOptions.ipRanges;
      this.action = updatePrivateEndpointWhitelistOptions.action;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceGuid the instanceGuid
     * @param ipRanges the ipRanges
     * @param action the action
     */
    public Builder(String instanceGuid, List<String> ipRanges, String action) {
      this.instanceGuid = instanceGuid;
      this.ipRanges = ipRanges;
      this.action = action;
    }

    /**
     * Builds a UpdatePrivateEndpointWhitelistOptions.
     *
     * @return the new UpdatePrivateEndpointWhitelistOptions instance
     */
    public UpdatePrivateEndpointWhitelistOptions build() {
      return new UpdatePrivateEndpointWhitelistOptions(this);
    }

    /**
     * Adds an ipRanges to ipRanges.
     *
     * @param ipRanges the new ipRanges
     * @return the UpdatePrivateEndpointWhitelistOptions builder
     */
    public Builder addIpRanges(String ipRanges) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(ipRanges,
        "ipRanges cannot be null");
      if (this.ipRanges == null) {
        this.ipRanges = new ArrayList<String>();
      }
      this.ipRanges.add(ipRanges);
      return this;
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the UpdatePrivateEndpointWhitelistOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the ipRanges.
     * Existing ipRanges will be replaced.
     *
     * @param ipRanges the ipRanges
     * @return the UpdatePrivateEndpointWhitelistOptions builder
     */
    public Builder ipRanges(List<String> ipRanges) {
      this.ipRanges = ipRanges;
      return this;
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the UpdatePrivateEndpointWhitelistOptions builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }
  }

  protected UpdatePrivateEndpointWhitelistOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ipRanges,
      "ipRanges cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    instanceGuid = builder.instanceGuid;
    ipRanges = builder.ipRanges;
    action = builder.action;
  }

  /**
   * New builder.
   *
   * @return a UpdatePrivateEndpointWhitelistOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceGuid.
   *
   * GUID of the service instance.
   *
   * @return the instanceGuid
   */
  public String instanceGuid() {
    return instanceGuid;
  }

  /**
   * Gets the ipRanges.
   *
   * List of IP ranges to add to or remove from the whitelist.
   *
   * @return the ipRanges
   */
  public List<String> ipRanges() {
    return ipRanges;
  }

  /**
   * Gets the action.
   *
   * Update Whitelist IP ranges. Add (or) Delete.
   *
   * @return the action
   */
  public String action() {
    return action;
  }
}

