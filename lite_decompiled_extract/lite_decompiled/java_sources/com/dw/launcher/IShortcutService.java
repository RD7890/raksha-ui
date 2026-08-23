package com.dw.launcher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/runner/work/Launcher-Decompiled/Launcher-Decompiled/extracted_dex/DwNewLauncher3_classes.dex */
public interface IShortcutService extends IInterface {
    public static final String DESCRIPTOR = "com.dw.launcher.IShortcutService";

    public static class Default implements IShortcutService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.dw.launcher.IShortcutService
        public byte[] getBitmap(String packageName, String className) throws RemoteException {
            return null;
        }
    }

    byte[] getBitmap(String packageName, String className) throws RemoteException;

    public static abstract class Stub extends Binder implements IShortcutService {
        static final int TRANSACTION_getBitmap = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IShortcutService.DESCRIPTOR);
        }

        public static IShortcutService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(IShortcutService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IShortcutService)) {
                return (IShortcutService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IShortcutService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IShortcutService.DESCRIPTOR);
                return true;
            }
            if (code == 1) {
                byte[] bitmap = getBitmap(data.readString(), data.readString());
                reply.writeNoException();
                reply.writeByteArray(bitmap);
                return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IShortcutService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IShortcutService.DESCRIPTOR;
            }

            @Override // com.dw.launcher.IShortcutService
            public byte[] getBitmap(String packageName, String className) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IShortcutService.DESCRIPTOR);
                    parcelObtain.writeString(packageName);
                    parcelObtain.writeString(className);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createByteArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
