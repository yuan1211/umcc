package kr.co.comwel.umcc;

import kr.co.comwel.umcc.service.MemberService.MemberQueryService;
import kr.co.comwel.umcc.service.MissionService.MissionQueryService;
import kr.co.comwel.umcc.service.ReviewService.ReviewQueryService;
import kr.co.comwel.umcc.service.StoreService.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaAuditing
public class UmccApplication {

    public static void main(String[] args) {

        SpringApplication.run(UmccApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);
            ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
            MemberQueryService memberService = context.getBean(MemberQueryService.class);
            MissionQueryService missionService = context.getBean(MissionQueryService.class);

            // 파라미터 값 설정
            String name = null;
            Float score = null;
            String comment = null;
            String address = null;
            String email = null;
            Integer point = null;
            LocalDate birth = null;
            Float reward = null;
            String description = "미션";

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);

            storeService.findStoresByNameAndScore(name, score)
                    .forEach(System.out::println);

            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("comment : " + comment);
            System.out.println("Score: " + score);


            reviewService.findReviewByCommentAndScore(comment, score)
                    .forEach(review -> System.out.println("Review: " + review));


            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("name : " + name);
            System.out.println("point : " + point);
            System.out.println("email : " + email);
            System.out.println("address : " + address);
            System.out.println("birth : " + birth);

            memberService.findMemberAll(name,point, email, birth, address)
                    .forEach(member -> System.out.println("Member : " + member));


            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("reward : " + reward);
            System.out.println("description : " + description);

            missionService.findMissionByRewardAndDescription(reward, description)
                    .forEach(mission -> System.out.println("Mission : " + mission));
        };


}}
