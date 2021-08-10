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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Custom action details for customization.
 */
public class AnalyticsEngineCustomAction extends GenericModel {

  /**
   * Customization type.
   */
  public interface Type {
    /** bootstrap. */
    String BOOTSTRAP = "bootstrap";
  }

  protected String name;
  protected String type;
  protected AnalyticsEngineCustomActionScript script;
  @SerializedName("script_params")
  protected List<String> scriptParams;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String type;
    private AnalyticsEngineCustomActionScript script;
    private List<String> scriptParams;

    private Builder(AnalyticsEngineCustomAction analyticsEngineCustomAction) {
      this.name = analyticsEngineCustomAction.name;
      this.type = analyticsEngineCustomAction.type;
      this.script = analyticsEngineCustomAction.script;
      this.scriptParams = analyticsEngineCustomAction.scriptParams;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a AnalyticsEngineCustomAction.
     *
     * @return the new AnalyticsEngineCustomAction instance
     */
    public AnalyticsEngineCustomAction build() {
      return new AnalyticsEngineCustomAction(this);
    }

    /**
     * Adds an scriptParams to scriptParams.
     *
     * @param scriptParams the new scriptParams
     * @return the AnalyticsEngineCustomAction builder
     */
    public Builder addScriptParams(String scriptParams) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(scriptParams,
        "scriptParams cannot be null");
      if (this.scriptParams == null) {
        this.scriptParams = new ArrayList<String>();
      }
      this.scriptParams.add(scriptParams);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AnalyticsEngineCustomAction builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AnalyticsEngineCustomAction builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the script.
     *
     * @param script the script
     * @return the AnalyticsEngineCustomAction builder
     */
    public Builder script(AnalyticsEngineCustomActionScript script) {
      this.script = script;
      return this;
    }

    /**
     * Set the scriptParams.
     * Existing scriptParams will be replaced.
     *
     * @param scriptParams the scriptParams
     * @return the AnalyticsEngineCustomAction builder
     */
    public Builder scriptParams(List<String> scriptParams) {
      this.scriptParams = scriptParams;
      return this;
    }
  }

  protected AnalyticsEngineCustomAction(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    type = builder.type;
    script = builder.script;
    scriptParams = builder.scriptParams;
  }

  /**
   * New builder.
   *
   * @return a AnalyticsEngineCustomAction builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Custom action name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Customization type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the script.
   *
   * Customization script details.
   *
   * @return the script
   */
  public AnalyticsEngineCustomActionScript script() {
    return script;
  }

  /**
   * Gets the scriptParams.
   *
   * Customization script parameters.
   *
   * @return the scriptParams
   */
  public List<String> scriptParams() {
    return scriptParams;
  }
}

