package com.example.updateapitask.cache;

import java.util.List;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheCustomizer
    implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

  @Override
  public void customize(ConcurrentMapCacheManager cacheManager) {
    cacheManager.setCacheNames(List.of("statsByDateFromDocument",
        "statsByAsinFromDocument", "allStatsByDate", "allStatsByAsin",
        "periodStatsByDate", "listStatsByAsin"));
  }
}
