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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResizeClusterOptions model.
 */
public class ResizeClusterOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResizeClusterOptions() throws Throwable {
    ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest resizeClusterRequestModel = new ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest.Builder()
      .computeNodesCount(Long.valueOf("26"))
      .build();
    assertEquals(resizeClusterRequestModel.computeNodesCount(), Long.valueOf("26"));

    ResizeClusterOptions resizeClusterOptionsModel = new ResizeClusterOptions.Builder()
      .instanceGuid("testString")
      .body(resizeClusterRequestModel)
      .build();
    assertEquals(resizeClusterOptionsModel.instanceGuid(), "testString");
    assertEquals(resizeClusterOptionsModel.body(), resizeClusterRequestModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResizeClusterOptionsError() throws Throwable {
    new ResizeClusterOptions.Builder().build();
  }

}