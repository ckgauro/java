package com.gauro.demo.apiclient;

import com.gauro.demo.domain.github.GitHubPosition;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.gauro.demo.util.CommonUtil.startTimer;

/**
 * @author Chandra
 */
public class GitHubJobsClient {
    private WebClient webClient;

    public GitHubJobsClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<GitHubPosition> invokeGithubJobsApi_withPageNumber(int pageName, String description){
        String url= UriComponentsBuilder.fromUriString("/position.json")
                .queryParam("description", description)
                .queryParam("page",pageName)
                .buildAndExpand()
                .toString();

        System.out.println("url: "+url);

        List<GitHubPosition> gitHubPositions=webClient.get().uri(url)
                .retrieve()
                .bodyToFlux(GitHubPosition.class)
                .collectList()
                .block();

        return gitHubPositions;

    }

    public List<GitHubPosition> invokeGitHubJobApi_withMultiplePageNumber_CF(List<Integer> pageList, String description){
        startTimer();

        List<CompletableFuture<List<GitHubPosition>>> getHubPositions=pageList.stream()
                .map(pageNum->CompletableFuture.supplyAsync(()->invokeGithubJobsApi_withPageNumber(pageNum, description)))
                .collect(Collectors.toList());
        //CompletableFuture
        return null;
    }


}
