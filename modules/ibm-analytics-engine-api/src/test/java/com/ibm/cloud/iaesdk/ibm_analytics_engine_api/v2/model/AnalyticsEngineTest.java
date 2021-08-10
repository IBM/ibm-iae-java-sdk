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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngine;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineClusterNode;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineUserCredentials;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ServiceEndpoints;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AnalyticsEngine model.
 */
public class AnalyticsEngineTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnalyticsEngine() throws Throwable {
    AnalyticsEngine analyticsEngineModel = new AnalyticsEngine();
    assertNull(analyticsEngineModel.getId());
    assertNull(analyticsEngineModel.getName());
    assertNull(analyticsEngineModel.getServicePlan());
    assertNull(analyticsEngineModel.getHardwareSize());
    assertNull(analyticsEngineModel.getSoftwarePackage());
    assertNull(analyticsEngineModel.getDomain());
    assertNull(analyticsEngineModel.getCreationTime());
    assertNull(analyticsEngineModel.getCommisionTime());
    assertNull(analyticsEngineModel.getDecommisionTime());
    assertNull(analyticsEngineModel.getDeletionTime());
    assertNull(analyticsEngineModel.getStateChangeTime());
    assertNull(analyticsEngineModel.getState());
    assertNull(analyticsEngineModel.getNodes());
    assertNull(analyticsEngineModel.getUserCredentials());
    assertNull(analyticsEngineModel.getServiceEndpoints());
    assertNull(analyticsEngineModel.getServiceEndpointsIp());
    assertNull(analyticsEngineModel.getPrivateEndpointWhitelist());
  }
}