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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstanceHomeOptions model.
 */
public class SetInstanceHomeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstanceHomeOptions() throws Throwable {
    SetInstanceHomeOptions setInstanceHomeOptionsModel = new SetInstanceHomeOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .newInstanceId("testString")
      .newProvider("ibm-cos")
      .newType("objectstore")
      .newRegion("us-south")
      .newEndpoint("s3.direct.us-south.cloud-object-storage.appdomain.cloud")
      .newHmacAccessKey("821**********0ae")
      .newHmacSecretKey("03e****************4fc3")
      .build();
    assertEquals(setInstanceHomeOptionsModel.instanceId(), "e64c907a-e82f-46fd-addc-ccfafbd28b09");
    assertEquals(setInstanceHomeOptionsModel.newInstanceId(), "testString");
    assertEquals(setInstanceHomeOptionsModel.newProvider(), "ibm-cos");
    assertEquals(setInstanceHomeOptionsModel.newType(), "objectstore");
    assertEquals(setInstanceHomeOptionsModel.newRegion(), "us-south");
    assertEquals(setInstanceHomeOptionsModel.newEndpoint(), "s3.direct.us-south.cloud-object-storage.appdomain.cloud");
    assertEquals(setInstanceHomeOptionsModel.newHmacAccessKey(), "821**********0ae");
    assertEquals(setInstanceHomeOptionsModel.newHmacSecretKey(), "03e****************4fc3");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstanceHomeOptionsError() throws Throwable {
    new SetInstanceHomeOptions.Builder().build();
  }

}