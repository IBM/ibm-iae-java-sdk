/*
 * (C) Copyright IBM Corp. 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Service Endpoints.
 */
public class ServiceEndpoints extends GenericModel {

  @SerializedName("phoenix_jdbc")
  protected String phoenixJdbc;
  @SerializedName("ambari_console")
  protected String ambariConsole;
  protected String livy;
  @SerializedName("spark_history_server")
  protected String sparkHistoryServer;
  @SerializedName("oozie_rest")
  protected String oozieRest;
  @SerializedName("hive_jdbc")
  protected String hiveJdbc;
  @SerializedName("notebook_gateway_websocket")
  protected String notebookGatewayWebsocket;
  @SerializedName("notebook_gateway")
  protected String notebookGateway;
  protected String webhdfs;
  protected String ssh;
  @SerializedName("spark_sql")
  protected String sparkSql;

  /**
   * Gets the phoenixJdbc.
   *
   * Phoenix JDBC service endpoint.
   *
   * @return the phoenixJdbc
   */
  public String getPhoenixJdbc() {
    return phoenixJdbc;
  }

  /**
   * Gets the ambariConsole.
   *
   * Amabri console service endpoint.
   *
   * @return the ambariConsole
   */
  public String getAmbariConsole() {
    return ambariConsole;
  }

  /**
   * Gets the livy.
   *
   * Livy service endpoint.
   *
   * @return the livy
   */
  public String getLivy() {
    return livy;
  }

  /**
   * Gets the sparkHistoryServer.
   *
   * Spark history server serivce endpoint.
   *
   * @return the sparkHistoryServer
   */
  public String getSparkHistoryServer() {
    return sparkHistoryServer;
  }

  /**
   * Gets the oozieRest.
   *
   * Oozie REST service endpi'.
   *
   * @return the oozieRest
   */
  public String getOozieRest() {
    return oozieRest;
  }

  /**
   * Gets the hiveJdbc.
   *
   * Hive JDBC service endpoint.
   *
   * @return the hiveJdbc
   */
  public String getHiveJdbc() {
    return hiveJdbc;
  }

  /**
   * Gets the notebookGatewayWebsocket.
   *
   * Notebook gateway websocket service endpoint.
   *
   * @return the notebookGatewayWebsocket
   */
  public String getNotebookGatewayWebsocket() {
    return notebookGatewayWebsocket;
  }

  /**
   * Gets the notebookGateway.
   *
   * Notebook gateway service endpoint.
   *
   * @return the notebookGateway
   */
  public String getNotebookGateway() {
    return notebookGateway;
  }

  /**
   * Gets the webhdfs.
   *
   * WebHDFS service endpoint.
   *
   * @return the webhdfs
   */
  public String getWebhdfs() {
    return webhdfs;
  }

  /**
   * Gets the ssh.
   *
   * SSH service endpoint.
   *
   * @return the ssh
   */
  public String getSsh() {
    return ssh;
  }

  /**
   * Gets the sparkSql.
   *
   * Spark SQL service endpoint.
   *
   * @return the sparkSql
   */
  public String getSparkSql() {
    return sparkSql;
  }
}

