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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createCustomizationRequest options.
 */
public class CreateCustomizationRequestOptions extends GenericModel {

  /**
   * Type of nodes to target for this customization.
   */
  public interface Target {
    /** all. */
    String ALL = "all";
    /** master-management. */
    String MASTER_MANAGEMENT = "master-management";
    /** data. */
    String DATA = "data";
    /** task. */
    String TASK = "task";
  }

  protected String instanceGuid;
  protected String target;
  protected List<AnalyticsEngineCustomAction> customActions;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private String target;
    private List<AnalyticsEngineCustomAction> customActions;

    private Builder(CreateCustomizationRequestOptions createCustomizationRequestOptions) {
      this.instanceGuid = createCustomizationRequestOptions.instanceGuid;
      this.target = createCustomizationRequestOptions.target;
      this.customActions = createCustomizationRequestOptions.customActions;
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
     * @param target the target
     * @param customActions the customActions
     */
    public Builder(String instanceGuid, String target, List<AnalyticsEngineCustomAction> customActions) {
      this.instanceGuid = instanceGuid;
      this.target = target;
      this.customActions = customActions;
    }

    /**
     * Builds a CreateCustomizationRequestOptions.
     *
     * @return the new CreateCustomizationRequestOptions instance
     */
    public CreateCustomizationRequestOptions build() {
      return new CreateCustomizationRequestOptions(this);
    }

    /**
     * Adds an customActions to customActions.
     *
     * @param customActions the new customActions
     * @return the CreateCustomizationRequestOptions builder
     */
    public Builder addCustomActions(AnalyticsEngineCustomAction customActions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(customActions,
        "customActions cannot be null");
      if (this.customActions == null) {
        this.customActions = new ArrayList<AnalyticsEngineCustomAction>();
      }
      this.customActions.add(customActions);
      return this;
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the CreateCustomizationRequestOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateCustomizationRequestOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the customActions.
     * Existing customActions will be replaced.
     *
     * @param customActions the customActions
     * @return the CreateCustomizationRequestOptions builder
     */
    public Builder customActions(List<AnalyticsEngineCustomAction> customActions) {
      this.customActions = customActions;
      return this;
    }
  }

  protected CreateCustomizationRequestOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.customActions,
      "customActions cannot be null");
    instanceGuid = builder.instanceGuid;
    target = builder.target;
    customActions = builder.customActions;
  }

  /**
   * New builder.
   *
   * @return a CreateCustomizationRequestOptions builder
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
   * Gets the target.
   *
   * Type of nodes to target for this customization.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the customActions.
   *
   * List of custom actions.
   *
   * @return the customActions
   */
  public List<AnalyticsEngineCustomAction> customActions() {
    return customActions;
  }
}

