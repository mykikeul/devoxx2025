package org.middle.earth;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/api/hobbit/unsecured")
public class HobbitUnsecuredResource {

  @GET
  @Path("pay-me")
  public int payMe(@QueryParam("age") Integer age) {
    return age >= 111 ? 10000 : 0;
  }
}
