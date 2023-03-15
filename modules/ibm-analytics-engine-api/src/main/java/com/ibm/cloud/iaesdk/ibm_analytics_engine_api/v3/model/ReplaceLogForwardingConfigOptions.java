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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceLogForwardingConfig options.
 */
public class ReplaceLogForwardingConfigOptions extends GenericModel {

  protected String instanceId;
  protected Boolean enabled;
  protected List<String> sources;
  protected List<String> tags;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Boolean enabled;
    private List<String> sources;
    private List<String> tags;

    /**
     * Instantiates a new Builder from an existing ReplaceLogForwardingConfigOptions instance.
     *
     * @param replaceLogForwardingConfigOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions) {
      this.instanceId = replaceLogForwardingConfigOptions.instanceId;
      this.enabled = replaceLogForwardingConfigOptions.enabled;
      this.sources = replaceLogForwardingConfigOptions.sources;
      this.tags = replaceLogForwardingConfigOptions.tags;
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
     * Builds a ReplaceLogForwardingConfigOptions.
     *
     * @return the new ReplaceLogForwardingConfigOptions instance
     */
    public ReplaceLogForwardingConfigOptions build() {
      return new ReplaceLogForwardingConfigOptions(this);
    }

    /**
     * Adds an sources to sources.
     *
     * @param sources the new sources
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder addSources(String sources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sources,
        "sources cannot be null");
      if (this.sources == null) {
        this.sources = new ArrayList<String>();
      }
      this.sources.add(sources);
      return this;
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the sources.
     * Existing sources will be replaced.
     *
     * @param sources the sources
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder sources(List<String> sources) {
      this.sources = sources;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the ReplaceLogForwardingConfigOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }
  }

  protected ReplaceLogForwardingConfigOptions() { }

  protected ReplaceLogForwardingConfigOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    enabled = builder.enabled;
    sources = builder.sources;
    tags = builder.tags;
  }

  /**
   * New builder.
   *
   * @return a ReplaceLogForwardingConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * ID of the Analytics Engine instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the enabled.
   *
   * Enable or disable log forwarding.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the sources.
   *
   * List of sources of logs that will be forwarded. By default, only 'spark-driver' logs are forwarded.
   *
   * @return the sources
   */
  public List<String> sources() {
    return sources;
  }

  /**
   * Gets the tags.
   *
   * List of tags to be applied to the logs being forwarded. They can be used to filter the logs in the IBM Log Analysis
   * server.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }
}

