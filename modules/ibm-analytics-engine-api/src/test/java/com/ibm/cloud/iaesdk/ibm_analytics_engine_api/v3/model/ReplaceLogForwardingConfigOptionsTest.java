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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceLogForwardingConfigOptions model.
 */
public class ReplaceLogForwardingConfigOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceLogForwardingConfigOptions() throws Throwable {
    ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptionsModel = new ReplaceLogForwardingConfigOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .enabled(true)
      .sources(java.util.Arrays.asList("spark-driver", "spark-executor"))
      .tags(java.util.Arrays.asList("<tag_1>", "<tag_2>", "<tag_n"))
      .build();
    assertEquals(replaceLogForwardingConfigOptionsModel.instanceId(), "e64c907a-e82f-46fd-addc-ccfafbd28b09");
    assertEquals(replaceLogForwardingConfigOptionsModel.enabled(), Boolean.valueOf(true));
    assertEquals(replaceLogForwardingConfigOptionsModel.sources(), java.util.Arrays.asList("spark-driver", "spark-executor"));
    assertEquals(replaceLogForwardingConfigOptionsModel.tags(), java.util.Arrays.asList("<tag_1>", "<tag_2>", "<tag_n"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceLogForwardingConfigOptionsError() throws Throwable {
    new ReplaceLogForwardingConfigOptions.Builder().build();
  }

}