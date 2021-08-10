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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingNodeSpec;
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
 * Unit test class for the AnalyticsEngineLoggingNodeSpec model.
 */
public class AnalyticsEngineLoggingNodeSpecTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnalyticsEngineLoggingNodeSpec() throws Throwable {
    AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
      .nodeType("management")
      .components(new java.util.ArrayList<String>(java.util.Arrays.asList("ambari-server")))
      .build();
    assertEquals(analyticsEngineLoggingNodeSpecModel.nodeType(), "management");
    assertEquals(analyticsEngineLoggingNodeSpecModel.components(), new java.util.ArrayList<String>(java.util.Arrays.asList("ambari-server")));

    String json = TestUtilities.serialize(analyticsEngineLoggingNodeSpecModel);

    AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModelNew = TestUtilities.deserialize(json, AnalyticsEngineLoggingNodeSpec.class);
    assertTrue(analyticsEngineLoggingNodeSpecModelNew instanceof AnalyticsEngineLoggingNodeSpec);
    assertEquals(analyticsEngineLoggingNodeSpecModelNew.nodeType(), "management");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyticsEngineLoggingNodeSpecError() throws Throwable {
    new AnalyticsEngineLoggingNodeSpec.Builder().build();
  }

}