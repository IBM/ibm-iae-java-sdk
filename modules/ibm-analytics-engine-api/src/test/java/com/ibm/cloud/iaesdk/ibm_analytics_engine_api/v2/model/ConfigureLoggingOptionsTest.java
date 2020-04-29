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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingNodeSpec;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ConfigureLoggingOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ConfigureLoggingOptions model.
 */
public class ConfigureLoggingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConfigureLoggingOptions() throws Throwable {
    AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
      .nodeType("management")
      .components(new ArrayList<String>(Arrays.asList("ambari-server")))
      .build();
    assertEquals(analyticsEngineLoggingNodeSpecModel.nodeType(), "management");
    assertEquals(analyticsEngineLoggingNodeSpecModel.components(), new ArrayList<String>(Arrays.asList("ambari-server")));

    AnalyticsEngineLoggingServer analyticsEngineLoggingServerModel = new AnalyticsEngineLoggingServer.Builder()
      .type("logdna")
      .credential("testString")
      .apiHost("testString")
      .logHost("testString")
      .owner("testString")
      .build();
    assertEquals(analyticsEngineLoggingServerModel.type(), "logdna");
    assertEquals(analyticsEngineLoggingServerModel.credential(), "testString");
    assertEquals(analyticsEngineLoggingServerModel.apiHost(), "testString");
    assertEquals(analyticsEngineLoggingServerModel.logHost(), "testString");
    assertEquals(analyticsEngineLoggingServerModel.owner(), "testString");

    ConfigureLoggingOptions configureLoggingOptionsModel = new ConfigureLoggingOptions.Builder()
      .instanceGuid("testString")
      .logSpecs(new ArrayList<AnalyticsEngineLoggingNodeSpec>(Arrays.asList(analyticsEngineLoggingNodeSpecModel)))
      .logServer(analyticsEngineLoggingServerModel)
      .build();
    assertEquals(configureLoggingOptionsModel.instanceGuid(), "testString");
    assertEquals(configureLoggingOptionsModel.logSpecs(), new ArrayList<AnalyticsEngineLoggingNodeSpec>(Arrays.asList(analyticsEngineLoggingNodeSpecModel)));
    assertEquals(configureLoggingOptionsModel.logServer(), analyticsEngineLoggingServerModel);
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConfigureLoggingOptionsError() throws Throwable {
    new ConfigureLoggingOptions.Builder().build();
  }

}