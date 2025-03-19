package org.middle.earth.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ElfService {

  public int payMe(int age, int waist) {
    return age >= 133 ? waist * 100 : 0;
  }
}
