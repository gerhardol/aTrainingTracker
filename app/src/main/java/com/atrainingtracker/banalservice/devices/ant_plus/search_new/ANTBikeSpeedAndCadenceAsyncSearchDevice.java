/*
 * aTrainingTracker (ANT+ BTLE)
 * Copyright (C) 2011 - 2019 Rainer Blind <rainer.blind@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https://www.gnu.org/licenses/gpl-3.0
 */

package com.atrainingtracker.banalservice.devices.ant_plus.search_new;

import android.content.Context;

import com.atrainingtracker.banalservice.devices.DeviceType;
import com.atrainingtracker.banalservice.devices.ant_plus.search_new.ANTSearchForNewDevicesEngineMultiDeviceSearch.IANTAsyncSearchEngineInterface;
import com.dsi.ant.plugins.antplus.pcc.AntPlusBikeSpeedDistancePcc;
import com.dsi.ant.plugins.antplus.pccbase.AntPluginPcc;
import com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch.MultiDeviceSearchResult;
import com.dsi.ant.plugins.antplus.pccbase.PccReleaseHandle;

public class ANTBikeSpeedAndCadenceAsyncSearchDevice extends MyANTAsyncSearchDevice {

    public ANTBikeSpeedAndCadenceAsyncSearchDevice(Context context, IANTAsyncSearchEngineInterface callback, MultiDeviceSearchResult deviceFound, boolean pairingRecommendation) {
        super(context, callback, DeviceType.BIKE_SPEED_AND_CADENCE, deviceFound, pairingRecommendation);
    }

    @Override
    protected void subscribeCommonEvents(AntPluginPcc antPluginPcc) {
        // not possible for combined devices
    }

    @Override
    protected PccReleaseHandle requestAccess() {
        return AntPlusBikeSpeedDistancePcc.requestAccess(mContext, mDeviceFound.getAntDeviceNumber(), 0, true, new MyResultReceiver<AntPlusBikeSpeedDistancePcc>(), new MyDeviceStateChangeReceiver());
    }

}
