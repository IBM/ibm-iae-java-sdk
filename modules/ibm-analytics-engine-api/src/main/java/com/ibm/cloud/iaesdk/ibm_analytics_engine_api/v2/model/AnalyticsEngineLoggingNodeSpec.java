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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Log specifications for node.
 */
public class AnalyticsEngineLoggingNodeSpec extends GenericModel {

  /**
   * Node type.
   */
  public interface NodeType {
    /** management. */
    String MANAGEMENT = "management";
    /** data. */
    String DATA = "data";
  }

  /**
   * Node components to be logged.
   */
  public interface Components {
    /** ambari-server. */
    String AMBARI_SERVER = "ambari-server";
    /** hadoop-mapreduce. */
    String HADOOP_MAPREDUCE = "hadoop-mapreduce";
    /** hadoop-yarn. */
    String HADOOP_YARN = "hadoop-yarn";
    /** hbase. */
    String HBASE = "hbase";
    /** hive. */
    String HIVE = "hive";
    /** jnbg. */
    String JNBG = "jnbg";
    /** knox. */
    String KNOX = "knox";
    /** livy2. */
    String LIVY2 = "livy2";
    /** spark2. */
    String SPARK2 = "spark2";
    /** yarn-apps. */
    String YARN_APPS = "yarn-apps";
  }

  @SerializedName("node_type")
  protected String nodeType;
  protected List<String> components;

  /**
   * Builder.
   */
  public static class Builder {
    private String nodeType;
    private List<String> components;

    private Builder(AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpec) {
      this.nodeType = analyticsEngineLoggingNodeSpec.nodeType;
      this.components = analyticsEngineLoggingNodeSpec.components;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param nodeType the nodeType
     * @param components the components
     */
    public Builder(String nodeType, List<String> components) {
      this.nodeType = nodeType;
      this.components = components;
    }

    /**
     * Builds a AnalyticsEngineLoggingNodeSpec.
     *
     * @return the new AnalyticsEngineLoggingNodeSpec instance
     */
    public AnalyticsEngineLoggingNodeSpec build() {
      return new AnalyticsEngineLoggingNodeSpec(this);
    }

    /**
     * Adds an components to components.
     *
     * @param components the new components
     * @return the AnalyticsEngineLoggingNodeSpec builder
     */
    public Builder addComponents(String components) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(components,
        "components cannot be null");
      if (this.components == null) {
        this.components = new ArrayList<String>();
      }
      this.components.add(components);
      return this;
    }

    /**
     * Set the nodeType.
     *
     * @param nodeType the nodeType
     * @return the AnalyticsEngineLoggingNodeSpec builder
     */
    public Builder nodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    /**
     * Set the components.
     * Existing components will be replaced.
     *
     * @param components the components
     * @return the AnalyticsEngineLoggingNodeSpec builder
     */
    public Builder components(List<String> components) {
      this.components = components;
      return this;
    }
  }

  protected AnalyticsEngineLoggingNodeSpec(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.nodeType,
      "nodeType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.components,
      "components cannot be null");
    nodeType = builder.nodeType;
    components = builder.components;
  }

  /**
   * New builder.
   *
   * @return a AnalyticsEngineLoggingNodeSpec builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the nodeType.
   *
   * Node type.
   *
   * @return the nodeType
   */
  public String nodeType() {
    return nodeType;
  }

  /**
   * Gets the components.
   *
   * Node components to be monitored.
   *
   * @return the components
   */
  public List<String> components() {
    return components;
  }
}

