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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Customization script details.
 */
public class AnalyticsEngineCustomActionScript extends GenericModel {

  /**
   * Defines where to access the customization script.
   */
  public interface SourceType {
    /** http. */
    String HTTP = "http";
    /** https. */
    String HTTPS = "https";
    /** BluemixSwift. */
    String BLUEMIXSWIFT = "BluemixSwift";
    /** SoftLayerSwift. */
    String SOFTLAYERSWIFT = "SoftLayerSwift";
    /** CosS3. */
    String COSS3 = "CosS3";
  }

  @SerializedName("source_type")
  protected String sourceType;
  @SerializedName("script_path")
  protected String scriptPath;
  @SerializedName("source_props")
  protected Map<String, Object> sourceProps;

  /**
   * Builder.
   */
  public static class Builder {
    private String sourceType;
    private String scriptPath;
    private Map<String, Object> sourceProps;

    private Builder(AnalyticsEngineCustomActionScript analyticsEngineCustomActionScript) {
      this.sourceType = analyticsEngineCustomActionScript.sourceType;
      this.scriptPath = analyticsEngineCustomActionScript.scriptPath;
      this.sourceProps = analyticsEngineCustomActionScript.sourceProps;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AnalyticsEngineCustomActionScript.
     *
     * @return the new AnalyticsEngineCustomActionScript instance
     */
    public AnalyticsEngineCustomActionScript build() {
      return new AnalyticsEngineCustomActionScript(this);
    }

    /**
     * Set the sourceType.
     *
     * @param sourceType the sourceType
     * @return the AnalyticsEngineCustomActionScript builder
     */
    public Builder sourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    /**
     * Set the scriptPath.
     *
     * @param scriptPath the scriptPath
     * @return the AnalyticsEngineCustomActionScript builder
     */
    public Builder scriptPath(String scriptPath) {
      this.scriptPath = scriptPath;
      return this;
    }

    /**
     * Set the sourceProps.
     *
     * @param sourceProps the sourceProps
     * @return the AnalyticsEngineCustomActionScript builder
     */
    public Builder sourceProps(Map<String, Object> sourceProps) {
      this.sourceProps = sourceProps;
      return this;
    }
  }

  protected AnalyticsEngineCustomActionScript(Builder builder) {
    sourceType = builder.sourceType;
    scriptPath = builder.scriptPath;
    sourceProps = builder.sourceProps;
  }

  /**
   * New builder.
   *
   * @return a AnalyticsEngineCustomActionScript builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sourceType.
   *
   * Defines where to access the customization script.
   *
   * @return the sourceType
   */
  public String sourceType() {
    return sourceType;
  }

  /**
   * Gets the scriptPath.
   *
   * Path to the customization script.
   *
   * @return the scriptPath
   */
  public String scriptPath() {
    return scriptPath;
  }

  /**
   * Gets the sourceProps.
   *
   * Customization script properties.
   *
   * @return the sourceProps
   */
  public Map<String, Object> sourceProps() {
    return sourceProps;
  }
}

