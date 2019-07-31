package com.example.wearepkk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cuneytayyildiz.onboarder.OnboarderActivity;
import com.cuneytayyildiz.onboarder.OnboarderPage;
import com.cuneytayyildiz.onboarder.utils.OnboarderPageChangeListener;

import java.util.Arrays;
import java.util.List;

public class IntroActivity extends OnboarderActivity implements OnboarderPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<OnboarderPage> pages = Arrays.asList(
                new OnboarderPage.Builder()
                        .title("We are PKK")
                        .description("Aplikasi Seputar PKK")
                        .imageResourceId(R.drawable.splash)
                        .backgroundColorId(R.color.color_donut)
                        .titleColor(R.color.black_transparent)
                        .descriptionColor(R.color.black_transparent)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("PKKPedia")
                        .description("Buku Saku PKK")
                        .imageResourceId(R.drawable.book)
                        .backgroundColorId(R.color.color_froyo)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Event")
                        .description("Event Event PKK")
                        .imageResourceId(R.drawable.event)
                        .backgroundColorId(R.color.color_kitkat)
                        .titleColor(R.color.black_transparent)
                        .descriptionColor(R.color.black_transparent)
                        .multilineDescriptionCentered(true)
                        .build()
        );
        setOnboarderPageChangeListener(this);
        initOnboardingPages(pages);
        setDividerVisibility(View.GONE);
    }

    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(IntroActivity.this,MainActivity.class));
    }

    @Override
    public void onPageChanged(int position) {

    }
}
