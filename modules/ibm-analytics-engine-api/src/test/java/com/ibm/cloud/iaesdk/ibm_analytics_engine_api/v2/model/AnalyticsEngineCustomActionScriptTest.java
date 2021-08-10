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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomActionScript;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AnalyticsEngineCustomActionScript model.
 */
public class AnalyticsEngineCustomActionScriptTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnalyticsEngineCustomActionScript() throws Throwable {
    AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModel = new AnalyticsEngineCustomActionScript.Builder()
      .sourceType("http")
      .scriptPath("testString")
      .sourceProps(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(analyticsEngineCustomActionScriptModel.sourceType(), "http");
    assertEquals(analyticsEngineCustomActionScriptModel.scriptPath(), "testString");
    assertEquals(analyticsEngineCustomActionScriptModel.sourceProps(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    String json = TestUtilities.serialize(analyticsEngineCustomActionScriptModel);

    AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModelNew = TestUtilities.deserialize(json, AnalyticsEngineCustomActionScript.class);
    assertTrue(analyticsEngineCustomActionScriptModelNew instanceof AnalyticsEngineCustomActionScript);
    assertEquals(analyticsEngineCustomActionScriptModelNew.sourceType(), "http");
    assertEquals(analyticsEngineCustomActionScriptModelNew.scriptPath(), "testString");
    assertEquals(analyticsEngineCustomActionScriptModelNew.sourceProps().toString(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } }.toString());
  }
}