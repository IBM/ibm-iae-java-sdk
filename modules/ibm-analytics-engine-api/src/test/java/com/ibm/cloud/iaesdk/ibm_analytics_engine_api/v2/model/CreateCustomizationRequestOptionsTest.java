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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomAction;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomActionScript;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.CreateCustomizationRequestOptions;
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
 * Unit test class for the CreateCustomizationRequestOptions model.
 */
public class CreateCustomizationRequestOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateCustomizationRequestOptions() throws Throwable {
    AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModel = new AnalyticsEngineCustomActionScript.Builder()
      .sourceType("http")
      .scriptPath("testString")
      .sourceProps(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(analyticsEngineCustomActionScriptModel.sourceType(), "http");
    assertEquals(analyticsEngineCustomActionScriptModel.scriptPath(), "testString");
    assertEquals(analyticsEngineCustomActionScriptModel.sourceProps(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    AnalyticsEngineCustomAction analyticsEngineCustomActionModel = new AnalyticsEngineCustomAction.Builder()
      .name("testString")
      .type("bootstrap")
      .script(analyticsEngineCustomActionScriptModel)
      .scriptParams(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(analyticsEngineCustomActionModel.name(), "testString");
    assertEquals(analyticsEngineCustomActionModel.type(), "bootstrap");
    assertEquals(analyticsEngineCustomActionModel.script(), analyticsEngineCustomActionScriptModel);
    assertEquals(analyticsEngineCustomActionModel.scriptParams(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CreateCustomizationRequestOptions createCustomizationRequestOptionsModel = new CreateCustomizationRequestOptions.Builder()
      .instanceGuid("testString")
      .target("all")
      .customActions(new java.util.ArrayList<AnalyticsEngineCustomAction>(java.util.Arrays.asList(analyticsEngineCustomActionModel)))
      .build();
    assertEquals(createCustomizationRequestOptionsModel.instanceGuid(), "testString");
    assertEquals(createCustomizationRequestOptionsModel.target(), "all");
    assertEquals(createCustomizationRequestOptionsModel.customActions(), new java.util.ArrayList<AnalyticsEngineCustomAction>(java.util.Arrays.asList(analyticsEngineCustomActionModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomizationRequestOptionsError() throws Throwable {
    new CreateCustomizationRequestOptions.Builder().build();
  }

}