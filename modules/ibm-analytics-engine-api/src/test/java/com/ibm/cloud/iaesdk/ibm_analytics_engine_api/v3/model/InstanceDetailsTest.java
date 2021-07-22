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

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsDefaultRuntime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsInstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the InstanceDetails model.
 */
public class InstanceDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInstanceDetails() throws Throwable {
    InstanceDetails instanceDetailsModel = new InstanceDetails();
    assertNull(instanceDetailsModel.getInstanceId());
    assertNull(instanceDetailsModel.getState());
    assertNull(instanceDetailsModel.getStateChangeTime());
    assertNull(instanceDetailsModel.getDefaultRuntime());
    assertNull(instanceDetailsModel.getInstanceHome());
    assertNull(instanceDetailsModel.getDefaultConfig());
  }
}