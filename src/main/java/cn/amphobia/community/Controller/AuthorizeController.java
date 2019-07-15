package cn.amphobia.community.Controller;

import cn.amphobia.community.dto.AccessTokenDTO;
import cn.amphobia.community.dto.GithubUser;
import cn.amphobia.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author amphobia
 * @data 2019/7/15 0015-15:11
 */
@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @Value("${Github.client.id}")
    private String clientId;

    @Value("${Github.client.secret}")
    private String clientSecret;

    @Value("${Github.client.uri}")
    private String clientUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(clientUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getId());
        return "index";
    }
}
