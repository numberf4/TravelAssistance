package com.number4.travelassistance.viewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapViewModel extends ViewModel {
    private LifecycleOwner lifecycleOwner;

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner;
    }

    private MutableLiveData<Boolean> isPickSearch = new MutableLiveData<Boolean>(false);

    public MutableLiveData<Boolean> getIsPickSearch() {
        return isPickSearch;
    }
     public void changeStatusIsPick(){
        Boolean value = getIsPickSearch().getValue();
        this.isPickSearch.postValue(!value);
    }
}
