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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Application;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Runtime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Application model.
 */
public class ApplicationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApplication() throws Throwable {
    Application applicationModel = new Application();
    assertNull(applicationModel.getId());
    assertNull(applicationModel.getHref());
    assertNull(applicationModel.getRuntime());
    assertNull(applicationModel.getSparkApplicationId());
    assertNull(applicationModel.getSparkApplicationName());
    assertNull(applicationModel.getState());
    assertNull(applicationModel.getSparkUi());
    assertNull(applicationModel.getSubmissionTime());
    assertNull(applicationModel.getStartTime());
    assertNull(applicationModel.getEndTime());
    assertNull(applicationModel.getFinishTime());
    assertNull(applicationModel.getAutoTerminationTime());
  }
}