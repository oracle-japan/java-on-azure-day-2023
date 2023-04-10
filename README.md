# Java on Azure Day 2023

## Kubernetes

ネームスペースを作成します。

```bash
kubectl create namespace apps
```

ダウンロードし、展開済みの Wallet ファイルを ConfigMap として登録します。ここでは、`wallet/` に該当の Wallet が展開されていることとします。

```bash
kubectl create configmap wallet-cm --from-file wallet/ --namespace apps
```

アプリケーションの接続情報を Secret として登録します。

```bash
kubectl create secret generic datasource-secret \
    --from-litetal=url=<接続 URL> \
    --from-literal=username=<ユーザ名> \
    --from-literal=password=<パスワード> \
    --namespace app
```
