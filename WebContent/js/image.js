function getFolder(driver) {

	fso = new ActiveXObject("Scripting.FileSystemObject");

	var eSubFolders = new Enumerator(fso.GetFolder(driver).SubFolders); // ��ȡ��Ŀ¼

	var eFiles = new Enumerator(fso.GetFolder(driver).files); // ��ȡ�ļ�

	var itemSubFolder = "";

	var i = 0;

	var table = "<table border='1' width='97%'>";

	if (!fso.GetFolder(driver.replace(new RegExp("\\\\", "g"), "\\\\")).IsRootFolder) { // �ж��Ƿ�Ϊ��Ŀ

		var fatherDriver1 = new String(fso.GetFolder(driver).ParentFolder);

		var fatherDriver = fatherDriver1.replace(new RegExp("\\\\", "g"),
				"\\\\");

		var tr = "<tr><td height='27px'><a href='#' onclick='getFolder(\""
				+ fatherDriver + "\");'>������һ��</a></td></tr>";

	} else {

		var tr = "";

	}

	for (; !eSubFolders.atEnd(); eSubFolders.moveNext()) {

		itemSubFolder = eSubFolders.item(); // ��ȡ���е�һ��Ŀ¼

		var eSubFolder_son = new Enumerator(
				fso.GetFolder(itemSubFolder).SubFolders); // ��ȡ��Ŀ¼����Ŀ¼

		/** *********************�ж��Ƿ����ͼƬ�ļ�************************************** */

		var eSubFolder_file = new Enumerator(fso.GetFolder(itemSubFolder).files); // ��ȡ��Ŀ¼�������ļ�

		for (; !eSubFolder_file.atEnd(); eSubFolder_file.moveNext()) {

			var itemSubFolder_file = eSubFolder_file.item();

			var flag = false; // �Ƿ����ͼƬ�ļ��ı�Ǳ���

			if (itemSubFolder_file.Type.indexOf("JPG") != -1
					|| itemSubFolder_file.Type.indexOf("JPEG") != -1

					|| itemSubFolder_file.Type.indexOf("GIF") != -1) {

				flag = true;

				break; // ����forѭ��

			}

		}

		/** **************************************************************************** */

		if (!eSubFolder_son.atEnd() || flag) { // ����ͼƬ�ļ��������ļ���ʱ��ʾ������

			var str_itemSubFolder = new String(itemSubFolder);

			itemSubFolder_ = str_itemSubFolder.replace(new RegExp("\\\\", "g"),
					"\\\\");

			tr = tr + "<tr><td><a href='#' onclick='getFolder(\""
					+ itemSubFolder_ + "\")'>" + itemSubFolder
					+ "</a></td></tr>";

		} else {

			tr = tr + "<tr><td>" + itemSubFolder + "</td></tr>";

		}

		i++;

	}

	table = table + tr + "</table>";

	document.getElementById("listDir").innerHTML = table; // ����ȡ����Ŀ¼��ӵ�Ŀ¼�б�<div>��

	// ��ȡͼƬ�ļ�

	var j = 0;

	imglist = "";

	for (; !eFiles.atEnd(); eFiles.moveNext()) {

		var itemFile = eFiles.item(); // ��ȡ���е�һ���ļ�

		if (itemFile.Type.indexOf("JPG") != -1
				|| itemFile.Type.indexOf("JPEG") != -1
				|| itemFile.Type.indexOf("GIF") != -1) {

			imglist = imglist
					+ "<div style='width:160px;float:left'>"
					+

					"<input name='sourceImg' type='checkbox' id='sourceImg' class='noborder' value='"
					+ itemFile +

					"'><img src='" + itemFile + "' alt='" + itemFile.name
					+ "' width='128' height='94' border='1'></div>";

			j++;

		}

	}

	document.getElementById("listFile").innerHTML = imglist; // ����ȡ��ͼƬ�ļ���ʾ����Դ�ļ����б���

}
