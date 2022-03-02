package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3;

import java.util.HashMap;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerStartResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StartSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StopSparkHistoryServerOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;

public class SampleJavaSDK {
	
	private static IbmAnalyticsEngineApi ibmAnalyticsEngineApiService;

	private static String IAM_API_KEY = "Rn2CWcyuFuk8-HxDxISwkAVvaZPayVHAzllDbOxcl9Ea";
	private static String IAE_ENDPOINT_URL = "https://sbn-cpg.us-south.ae.test.cloud.ibm.com";
	private static String API_AUTH_URL = "https://iam.test.cloud.ibm.com/identity/token";
	
	public static void main(String[] args) {
		HashMap<String, String> config = new HashMap<String, String>();
		config.put("APIKEY",IAM_API_KEY );
		config.put("AUTH_URL", API_AUTH_URL);
		
		try {
		      // Create an IAM authenticator.
			 Authenticator authenticator = IamAuthenticator.fromConfiguration(config);
			 
		      // Construct the service client.
		      ibmAnalyticsEngineApiService = new IbmAnalyticsEngineApi(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME, authenticator);
		      // Set our service URL.
		      ibmAnalyticsEngineApiService.setServiceUrl(IAE_ENDPOINT_URL);
		      
		   // Construct an instance of the GetInstanceOptions model
		      GetInstanceOptions getInstanceOptionsModel = new GetInstanceOptions.Builder()
		      .instanceId("fced0d7b-9394-46ee-b8d8-383b2e9992d7")
		      .build();
		      
		   // Invoke operation with valid options model (positive test)
		      Response<Instance> response = ibmAnalyticsEngineApiService.getInstance(getInstanceOptionsModel).execute();
		      Instance responseObj = response.getResult();
		      System.out.println(String.valueOf(responseObj));
		      
		      
		   //Construct an instance of the StartSparkHistoryServerOptions model  
		      StartSparkHistoryServerOptions startSparkHistoryServerOptionsModel = new StartSparkHistoryServerOptions.Builder()
		    	      .instanceId("fced0d7b-9394-46ee-b8d8-383b2e9992d7")
		    	      .build();
		      //Invoke operation with valid options model (positive test)
		      Response<SparkHistoryServerStartResponse> sparkHistoryServerStartResponse = ibmAnalyticsEngineApiService.startSparkHistoryServer(startSparkHistoryServerOptionsModel).execute();
		      SparkHistoryServerStartResponse sparkHistoryServerStartResponseResult = sparkHistoryServerStartResponse.getResult();
		      System.out.println(String.valueOf(sparkHistoryServerStartResponseResult));
		      
		      //Construct an instance of the GetSparkHistoryServerOptions model 
		      GetSparkHistoryServerOptions getSparkHistoryServerOptionsModel = new GetSparkHistoryServerOptions.Builder()
		    	      .instanceId("fced0d7b-9394-46ee-b8d8-383b2e9992d7")
		    	      .build();
		      //Invoke operation with valid options model (positive test)
		      Response<SparkHistoryServerResponse> sparkHistoryServerResponse = ibmAnalyticsEngineApiService.getSparkHistoryServer(getSparkHistoryServerOptionsModel).execute();
		      SparkHistoryServerResponse sparkHistoryServerResponseResult = sparkHistoryServerResponse.getResult();
		      System.out.println(String.valueOf(sparkHistoryServerResponseResult));
		      
		      //Construct an instance of the StopSparkHistoryServerOptions model 
		      StopSparkHistoryServerOptions stopSparkHistoryServerOptionsModel = new StopSparkHistoryServerOptions.Builder()
		    		       .instanceId("fced0d7b-9394-46ee-b8d8-383b2e9992d7")
		    		       .build();
		    //Invoke operation with valid options model (positive test)
		      Response<Void> stopSparkHistoryServerResponse = ibmAnalyticsEngineApiService.stopSparkHistoryServer(stopSparkHistoryServerOptionsModel).execute();
		      Void stopSparkHistoryServerResponsResult = stopSparkHistoryServerResponse.getResult();
		      System.out.println(String.valueOf(stopSparkHistoryServerResponsResult));
		}
		
		
	      catch (Exception e) {
	      System.out.println("Exception");
	      }

	}

}
