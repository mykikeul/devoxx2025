package org.middle.earth;

import io.quarkus.oidc.runtime.OidcJwtCallerPrincipal;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.json.JsonNumber;
import jakarta.json.JsonString;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/hobbit/secured")
public class HobbitSecuredResource {

  @Inject
  SecurityIdentity identity;

  @GET
  @Path("pay-me")
  public int payMe() {
    OidcJwtCallerPrincipal principal = (OidcJwtCallerPrincipal) identity.getPrincipal();
    JsonString race = (JsonString) principal.getClaims().getClaimValue("race");
    if (!"HOBBIT".equalsIgnoreCase(race.toString())) {
      throw new SecurityException("Race is not HOBBIT");
    }
    JsonNumber age = (JsonNumber) principal.getClaims().getClaimValue("age");
    return age.intValue() >= 111 ? 10000 : 0;
  }
}
